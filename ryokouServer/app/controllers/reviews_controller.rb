# coding: utf-8

# レビュー取得
# レビュー登録
# レビュー更新
# レビュー削除

class ReviewsController < ApplicationController

  # plans/
  # 全てのレビューを一覧取得する
  def index
    reviews = Review.all
    render :json => reviews.to_json
  end

  # GET /plans/1
  # GET /plans/1.xml
  # 指定したプランのレビューの一覧を取得する
  def show
  	
    
    reviews = Review.where("post_member_id=?",params['plan_id'])
	review = reviews[0]
    render :json => review
  end
  
  # GET /plans/new
  # GET /plans/new.xml
  def new
    member = Review.new
  end

  # GET /plans/1/edit
  def edit
    reviews = Review.find(params[:id])
  end

  # POST /plans
  # POST /plans.xml
  # レビューを登録する
  def create

    plan = Plan.where("member_id = ?",params['member_id']).where("plan_id = ?",params['plan_id'])[0]
    
    ##プランオブジェクト生成
    review = Review.new
    
    ##プラン情報登録
    review.post_member_id = params['post_member_id']
    review.member_id = params['member_id']
    review.plan_id = plan['id']
    review.review_star = params['review_star']
    review.comment = params['comment']
    
    review.save

	if review.save then
		render :json => {"result"=>true}
	else
		render :json => {"result"=>false}
	end
  end

  # PUT /plans/1
  # PUT /plans/1.xml
  # レビューを更新する
  def update
    destroy
    create
  end

  # DELETE /plans/1
  # DELETE /plans/1.xml
  # レビューを削除する
  def destroy
    p_review = params['review']
    
    review = Review.where("post_member_id=?",p_review['post_member_id']).where("member_id",p_review['member_id'])
    review.destroy
    
  end
  
end
