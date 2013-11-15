class CreateMembers < ActiveRecord::Migration
  def self.up
    create_table :members do |t|
      t.string :member_id
      t.string :member_nic
      t.datetime :member_birthday
      t.string :member_sex
      t.string :member_address
      t.integer :job_id
      t.string :member_mail
      t.string :member_passwd
      
      t.timestamps
    end
  end

  def self.down
    drop_table :members
  end
end
