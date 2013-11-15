class PlanCategory < ActiveRecord::Base
  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :plan_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :category_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  belongs_to :plan
  belongs_to :category
end
