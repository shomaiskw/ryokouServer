class CreateDestAccesses < ActiveRecord::Migration
  def self.up
    create_table :dest_accesses do |t|
	  t.string :member_id
	  t.string :plan_id
	  t.string :dest_id
	  t.string :dest_access_id
	  t.string :depart
	  t.string :arrival
	  t.datetime :depart_date
	  t.datetime :arrival_date
	  t.string :access_id
	  t.integer :dest_access_value
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :dest_accesses
  end
end
