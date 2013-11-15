class Destination < ActiveRecord::Base
  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :plan_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :dest_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :dest_name,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  validates :dest_value,	:presence=> true,
  						:numericality => true
  belongs_to :plan
  has_many :dest_access
end
