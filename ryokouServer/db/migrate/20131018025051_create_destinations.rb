class CreateDestinations < ActiveRecord::Migration
  def self.up
    create_table :destinations do |t|
	  t.string :member_id
	  t.string :plan_id
	  t.string :dest_id
	  t.string :dest_name
	  t.integer :dest_value
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :destinations
  end
end
