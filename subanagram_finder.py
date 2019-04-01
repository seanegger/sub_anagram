"""Python Sub-anagram Finder.

Usage:
    subanagram_finder.py [-h] word [word ...]

Run:
    subanagram_finder.py -h
for more details.

Prof. Josh Auerbach
Champlain College
CSI-380 Spring 2019
"""

import argparse


def letter_frequencies(word):
    """Return a dict mapping letters to their frequency (count) in word."""
    return dict(map(lambda letter: (letter, word.count(letter)), set(word)))


def load_dictionary(file_name="resources/words"):
    """Load list of words from disk."""
    with open(file_name, "r") as words_file:
        return list(map(lambda line: line.strip(), words_file))


def find_sub_anagrams(word, word_list):
    """Find all the words in word_list that are sub-anagrams of word.

    A sub-anagram means it is an anagram of a substring of word.
    """
    word_length = len(word)
    letter_counts = letter_frequencies(word.lower())

    def is_sub_anagram(other_word):
        """Test if other_word is a subanagram of word."""
        # if the other_word is longer than word, this is trivially false
        if word_length < len(other_word):
            return False

        other_letter_counts = letter_frequencies(other_word.lower())

        # for every letter in other_word, make sure
        # it appears in word at least as many times as in other_word
        return all(map(
            lambda letter: letter_counts.get(letter, 0) >=
            other_letter_counts[letter], other_letter_counts.keys()))

    return list(filter(is_sub_anagram, word_list))


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Sub-anagram Finder')
    parser.add_argument('words', metavar='word', nargs='+',
                        help='word to search for anagrams of')
    args = parser.parse_args()
    words = args.words

    dictionary = load_dictionary()
    all_anagrams = map(lambda word: find_sub_anagrams(word, dictionary), words)
    print('\n'.join(map(lambda anagrams: ' '.join(anagrams), all_anagrams)))
