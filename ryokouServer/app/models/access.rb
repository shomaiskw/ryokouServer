class Access < ActiveRecord::Base
  validates :access_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :access_name,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  has_many :dest_access
end
