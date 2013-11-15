# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended to check this file into your version control system.

ActiveRecord::Schema.define(:version => 20131018025229) do

  create_table "accesses", :force => true do |t|
    t.string   "access_id"
    t.string   "access_name"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "categories", :force => true do |t|
    t.string   "category_id"
    t.string   "category_name"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "dest_accesses", :force => true do |t|
    t.string   "member_id"
    t.string   "plan_id"
    t.string   "dest_id"
    t.string   "dest_access_id"
    t.string   "depart"
    t.string   "arrival"
    t.datetime "depart_date"
    t.datetime "arrival_date"
    t.string   "access_id"
    t.integer  "dest_access_value"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "destinations", :force => true do |t|
    t.string   "member_id"
    t.string   "plan_id"
    t.string   "dest_id"
    t.string   "dest_name"
    t.integer  "dest_value"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "jobs", :force => true do |t|
    t.string   "job_id"
    t.string   "job_name"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "members", :force => true do |t|
    t.string   "member_id"
    t.string   "member_nic"
    t.datetime "member_birthday"
    t.string   "member_sex"
    t.string   "member_address"
    t.string   "job_id"
    t.string   "member_mail"
    t.string   "member_passwd"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "plan_categories", :force => true do |t|
    t.string   "member_id"
    t.string   "plan_id"
    t.string   "category_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "plans", :force => true do |t|
    t.string   "member_id"
    t.string   "plan_id"
    t.string   "plan_name"
    t.integer  "plan_star"
    t.text     "plan_comment"
    t.integer  "plan_value"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "reviews", :force => true do |t|
    t.string   "post_member_id"
    t.string   "member_id"
    t.string   "plan_id"
    t.integer  "review_star"
    t.text     "comment"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end
