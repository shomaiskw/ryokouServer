class Review < ActiveRecord::Base
  validates :post_member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :plan_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :review_star,	:presence=> true,
  						:numericality => true
  validates :comment,	:presence=> true
  belongs_to :member
  belongs_to :plan
end
