class Acronym

  def self.abbreviate(sentence)
    sentence.scan(/\b[a-zA-Z]/).join.upcase
  end
end
