module ProteinTranslation(proteins) where

import Data.List.Split
import Data.Map as Map
import Control.Monad

proteins :: String -> Maybe [String]
proteins xs = sequence (takeWhile isNormalProtein (Prelude.map translate $ chunksOf 3 xs))
    where
        codon_protein_dict = Map.fromList
            [
                ("AUG", "Methionine"),
                ("UUU", "Phenylalanine"),
                ("UUC", "Phenylalanine"),
                ("UUA", "Leucine"),
                ("UUG", "Leucine"),
                ("UCU", "Serine"),
                ("UCC", "Serine"),
                ("UCA", "Serine"),
                ("UCG", "Serine"),
                ("UAU", "Tyrosine"),
                ("UAC", "Tyrosine"),
                ("UGU", "Cysteine"),
                ("UGC", "Cysteine"),
                ("UGG", "Tryptophan"),
                ("UAA", "STOP"),
                ("UAG", "STOP"),
                ("UGA", "STOP")
            ]
        translate cond = Map.lookup cond codon_protein_dict
        isNormalProtein protein = protein /= Just "STOP"
