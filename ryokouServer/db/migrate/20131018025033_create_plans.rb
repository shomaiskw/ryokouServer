class CreatePlans < ActiveRecord::Migration
  def self.up
    create_table :plans do |t|
	  t.string :member_id
	  t.string :plan_id
	  t.string :plan_name
	  t.integer :plan_star
	  t.text :plan_comment
	  t.integer :plan_value
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :plans
  end
end
