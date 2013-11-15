class CreatePlanCategories < ActiveRecord::Migration
  def self.up
    create_table :plan_categories do |t|
	  t.string :member_id
	  t.string :plan_id
	  t.string :category_id
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :plan_categories
  end
end
