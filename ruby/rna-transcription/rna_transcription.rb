class Complement

  DNA_COMPLEMENTS = Hash['G' => 'C', 'C' => 'G', 'A' => 'U', 'T' => 'A']

  def self.of_dna(seq)
    seq.chars.map {|x| DNA_COMPLEMENTS[x]}.join("")
  end
end
