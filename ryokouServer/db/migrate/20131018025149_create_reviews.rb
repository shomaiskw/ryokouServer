class CreateReviews < ActiveRecord::Migration
  def self.up
    create_table :reviews do |t|
	  t.string :post_member_id
	  t.string :member_id
	  t.string :plan_id
	  t.integer :review_star
	  t.text :comment
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :reviews
  end
end
