class Job < ActiveRecord::Base
  validates :job_id,	:presence=> true,
  			:length => {:minimum => 1,:maximum => 8} ,
  			:uniqueness=>true
  validates :job_name,	:presence=> true,
  			:length => {:minimum => 1,:maximum => 20}
  has_many :members
end
