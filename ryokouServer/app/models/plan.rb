class Plan < ActiveRecord::Base

  validates :member_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 16}
  validates :plan_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :plan_name,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  validates :plan_star,	:presence=> true
  validates :plan_comment,	:presence=> true
  validates :plan_value,	:presence=> true
  belongs_to :member
  has_many :members
  has_many :reviews
  has_many :destinations
  has_many :plan_categories
  
end