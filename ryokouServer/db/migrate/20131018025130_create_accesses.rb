class CreateAccesses < ActiveRecord::Migration
  def self.up
    create_table :accesses do |t|
	  t.string :access_id
	  t.string :access_name
	  
      t.timestamps
    end
  end

  def self.down
    drop_table :accesses
  end
end
