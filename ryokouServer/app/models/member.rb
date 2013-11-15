class Member < ActiveRecord::Base
  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16} ,
  						:uniqueness=>true
  validates :member_nic,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  validates :member_birthday,	:presence=> true
  validates :member_sex,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 1}
  validates :member_address,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 50}
  validates :job_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :member_mail,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 30}
  validates :member_passwd,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  has_many :reviews
  has_many :plans
  belongs_to:plan
  belongs_to :job
end
