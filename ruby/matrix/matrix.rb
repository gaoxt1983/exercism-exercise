class Matrix

  attr_reader :rows, :columns

  def initialize(str)
    @rows = str.scan(/[\d ]+/).map{|l| l.split(" ").map {|c| c.to_i}}
    @columns = rows.transpose
  end
end
