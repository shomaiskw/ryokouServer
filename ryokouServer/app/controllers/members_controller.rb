# coding: utf-8

# 会員1人の情報を登録
# 会員1人の情報を取得
# 会員1人の情報を更新
# 会員1人の情報を削除

class MembersController < ApplicationController

  # members/
  # 全ての会員の情報を一覧取得する
  def index
    members = Member.all
    render :json => members.to_json
  end

  # GET /members/1
  # GET /members/1.xml
  # 指定した会員の情報を取得する
  def show
    members = Member.where("member_id=?",params['member_id'])
	member = members[0]
    render :json => member
    
    
  end
  
  # GET /members/new
  # GET /members/new.xml
  def new
    member = Member.new
  end

  # GET /members/1/edit
  def edit
    @user = User.find(params[:id])
  end

  # POST /members
  # POST /members.xml
  # 会員を登録する
  def create

    member = Member.new
    
    member.member_id = params[:member_id]
    member.member_nic = params[:member_nic]
    member.member_birthday = params[:member_birthday]
    member.member_sex = params[:member_sex]
    member.member_address = params[:member_address]
    member.job_id = params[:job_id]
    member.member_mail = params[:member_mail]
    member.member_passwd = params[:member_passwd]

	if member.save then
	 	render :json => {"result"=>true}
	else
		render :json => {"result"=>false}
	end
  end

  # PUT /members/1
  # PUT /members/1.xml
  # 会員を更新する
  def update
    members = Member.find(params[:member_id])
    member = members[0]
    
    member.member_nic = params[:member_nic]
    member.member_birthday = params[:member_birthday]
    member.member_sex = params[:member_sex]
    member.member_address = params[:member_address]
    member.job_id = params[:job_id]
    member.member_mail = params[:member_mail]
    member.member_passwd = params[:member_passwd]

	if member.save then
		render :json => {"result"=>true}
	else
		render :json => {"result"=>false}
	end
  end

  # DELETE /members/1
  # DELETE /members/1.xml
  # 会員を削除する
  def destroy
    members = Member.find(params[:id])
    
	if members.destroy then
		render :json => {"result"=>true}
	else
		render :json => {"result"=>false}
	end
  end
  
end
