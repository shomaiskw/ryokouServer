# coding: UTF-8

# 全てのプランの一覧を取得
# プラン1つの情報を取得
# プラン1つの情報を登録
# プラン1つの情報を更新
#　プラン1つの情報を削除

class PlansController < ApplicationController

  # plans/
  # 全てのプランの一覧を取得
  def index
    search_text=params['text']
    search_cate=params['categories']
    
    if search_text == nil 
      search_text = ""
    end
    
    if search_cate == nil 
      search_cate = ""
    end
    
    if search_text != "" && search_cate != "" then
      #テキスト＆カテゴリ検索
      categories = PlanCategory.where("category_id IN (?)",search_cate).find(:all,:group=>"plan_id",:select=>"plan_id")

      array = Array.new(categories.length)
      i=0;
      categories.each do |cate|
        array[i] = cate["plan_id"]
        i = i+1
      end
    
      plans = Plan.where("plan_comment like ? OR plan_name like ?","%" + search_text + "%","%" + search_text + "%").where("id IN (?)", array).find(:all,:group=>"plan_id").to_json(:include=>[:plan_categories,:destinations])
    
    elsif  search_text != "" && search_cate == "" then
      #テキスト検索

      plans = Plan.where("plan_comment like ? OR plan_name like ?","%" + search_text + "%","%" + search_text + "%").to_json(:include=>[:plan_categories,:destinations])
    
    elsif  search_text == "" && search_cate != "" then
      #カテゴリ検索
      categories = PlanCategory.where("category_id IN (?)",search_cate).find(:all,:group=>"plan_id",:select=>"plan_id")

      array = Array.new(categories.length)
      i=0;
      categories.each do |cate|
        array[i] = cate["plan_id"]
        i = i+1
      end
      plans = Plan.where("id IN (?)", array).to_json(:include=>[:plan_categories,:destinations])
    else
      plans = Plan.all.to_json(:include=>[:plan_categories,:destinations])
    end

    render :json => plans
  end

  # GET /members/1
  # GET /members/1.xml
  # プラン1つの情報を取得
  def show
     p_plan = params['plan']

    plan = Plan.where("plan_id=?",params['plan_id']).where("member_id=?",params['member_id'])[0].to_json(:include=>[:plan_categories,:destinations,:members,:reviews])

    render :json => plan
  end
  
  def show
     p_plan = params['plan']

    plan = Plan.where("plan_id=?",params['plan_id']).where("member_id=?",params['member_id'])[0].to_json(:include=>[:plan_categories,:destinations,:members,:reviews])

    render :json => plan
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

    ##POST?????v???????擾
    p_plan = params['plan']
    p_plan_c = p_plan['categories']
    p_plan_d = p_plan['destinations']

    
    ##?v?????I?u?W?F?N?g????
    plan = Plan.new
    
    ##?v???????o?^
    plan.member_id = p_plan['member_id']
    plan.plan_id = p_plan['plan_id']
    plan.plan_name = p_plan['plan_name']
    plan.plan_star = p_plan['plan_star'].to_i
    plan.plan_comment = p_plan['plan_comment']
    plan.plan_value = p_plan['plan_value'].to_i
    
    plan.save

    ##?v?????J?e?S???o?^
    p_plan_c.each{|c|

       plan_c = PlanCategory.new
       plan_c.member_id = p_plan['member_id']
       plan_c.plan_id = plan.id
       plan_c.category_id = c
       plan_c.save
    }

    ##?v?????s????o?^
    p_plan_d.each{|d|
       d = d[1]
       dest = Destination.new
       dest.member_id = p_plan['member_id']
       dest.plan_id = plan.id
       dest.dest_id = d['dest_id']
       dest.dest_name = d['dest_name']
       dest.dest_value = d['dest_value'].to_i
       dest.save
       
       p_plan_d_a = d['dest_accesses']
       
       ##?v????????i?o?^
       p_plan_d_a.each{|a|
          a = a[1]
       
          dest_a = DestAccess.new
          dest_a.member_id = p_plan['member_id']
          dest_a.plan_id = plan.id
          dest_a.dest_id = dest.id
          dest_a.dest_access_id = a['dest_access_id']
          dest_a.depart = a['depart']
          dest_a.arrival = a['arrival']
          dest_a.depart_date = a['depart_date']
          dest_a.arrival_date = a['arrival_date']
          dest_a.access_id = a['access_id']
          dest_a.dest_access_value = a['dest_access_value'].to_i
    
          dest_a.save
       }
    
    }
    
	if plan.save then
		render :json => {"result"=>true}
	else
		render :json => {"result"=>false}
	end
  end

  # PUT /members/1
  # PUT /members/1.xml
  # 会員を更新する
  def update
    destroy
    create
  end

  # DELETE /members/1
  # DELETE /members/1.xml
  # 会員を削除する
  def destroy
    p_plan = params['plan']
    p_plan_m = p_plan['member_id']
    p_plan_i = p_plan['plan_id']
    
    plan_c = PlanCategory.where("member_id=?",p_plan_m).where("plan_id",p_plan_i)
    plan_c.destroy
    
    plan_d = Destination.where("member_id=?",p_plan_m).where("plan_id",p_plan_i)
    plan_d.destroy
    
    plan_a = DestAccess.where("member_id=?",p_plan_m).where("plan_id",p_plan_i)
    plan_a.destroy
    
    
  end

  # DELETE /members/1
  # DELETE /members/1.xml
  # 会員を削除する
  def rank
    ranking = Review.average(:review_star, :group => :plan_id,:order=>"average_review_star DESC",:limit=>10)
          
    keys = ranking.keys
    plan = Plan.where("id IN (?)",keys).reverse!
    render :json => plan.to_json
    
  end
end
