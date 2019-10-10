class Acronym

  def self.abbreviate(sentence)
    sentence.scan(/\w+/).map{|word| word[0].capitalize}.join
  end
end
