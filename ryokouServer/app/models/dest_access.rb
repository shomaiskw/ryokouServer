class DestAccess < ActiveRecord::Base
  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :plan_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :dest_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :dest_access_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}					
  validates :depart,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  validates :arrival,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  validates :depart_date,	:presence=> true
  validates :arrival_date,	:presence=> true
  validates :access_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :dest_access_value,	:presence=> true,
  						:numericality => true
  belongs_to :destination
  belongs_to :access
end
