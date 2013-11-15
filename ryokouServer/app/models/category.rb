class Category < ActiveRecord::Base
  validates :category_id,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 8}
  validates :category_name,	:presence=> true,
  						:length => {:minimum => 1,:maximum => 20}
  has_many :plan_categories
end
