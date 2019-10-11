class Acronym

  def self.abbreviate(sentence)
    sentence.scan(/\b[a-zA-Z]/).map{|x| x.capitalize}.join
  end
end
