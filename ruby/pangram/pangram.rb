require 'set'

class Pangram

  ALPHABETA = ('a'..'z').to_a.to_set

  def self.pangram?(sentence)
    ALPHABETA.subset?(sentence.downcase.chars.to_set)
  end
end
