class Triangle

  attr_reader :pairsEquality, :valid

  def initialize(ary)
    @valid = ary.all? {|x| x != 0} && ary.permutation(3).all?{|a| a[0] + a[1] >= a[2]}
    @pairsEquality = ary.combination(2).to_a.map {|x| x[0] == x[1]}
  end

  def equilateral?
    valid && pairsEquality.all? {|x| x}
  end

  def isosceles?
    valid && pairsEquality.any? {|x| x}
  end

  def scalene?
    valid && !isosceles?
  end
end
