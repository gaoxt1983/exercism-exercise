object ProteinTranslation {

  private[this] val CODON_PROTEIN_DICT = Map(
    "AUG" -> "Methionine",
    "UUU" -> "Phenylalanine",
    "UUC" -> "Phenylalanine",
    "UUA" -> "Leucine",
    "UUG" -> "Leucine",
    "UCU" -> "Serine",
    "UCC" -> "Serine",
    "UCA" -> "Serine",
    "UCG" -> "Serine",
    "UAU" -> "Tyrosine",
    "UAC" -> "Tyrosine",
    "UGU" -> "Cysteine",
    "UGC" -> "Cysteine",
    "UGG" -> "Tryptophan",
    "UAA" -> "STOP",
    "UAG" -> "STOP",
    "UGA" -> "STOP"
  )

  def proteins(sequence: String): Seq[String] = {
    sequence.grouped(3).flatMap(e => {
      CODON_PROTEIN_DICT.get(e)
    }).takeWhile(e => !e.equals("STOP")).toSeq
  }
}
