RyokouServer::Application.routes.draw do
  

match '/members/get' => 'members#show', :via => [:get, :post]
match '/members/add' => 'members#create', :via => [:get, :post]
match '/members/up' => 'members#update', :via => [:get, :post]
match '/members/del' => 'members#destroy', :via => [:get, :post]

match '/plans' => 'plans#index', :via => [:get, :post]
match '/plans/get' => 'plans#show', :via => [:get, :post]
match '/plans/add' => 'plans#create', :via => [:get, :post]
match '/plans/up' => 'plans#update', :via => [:get, :post]
match '/plans/del' => 'plans#destroy', :via => [:get, :post]
match '/plans/rank' => 'plans#rank', :via => [:get, :post]

match '/reviews' => 'reviews#index', :via => [:get, :post]
match '/reviews/get' => 'reviews#show', :via => [:get, :post]
match '/reviews/add' => 'reviews#create', :via => [:get, :post]
match '/reviews/up' => 'reviews#update', :via => [:get, :post]
match '/reviews/del' => 'reviews#destroy', :via => [:get, :post]

#  resources :members
#  resources :plans
#  resources :reviews
  
  
  #GET    'sample'     => 'books#index'
  #GET    'sample/:id' => 'books#show'
  #GET    'sample/new' => 'books#new'
  #POST   'sample'     => 'books#create'
  #GET    'sample/:id/edit' => 'books#edit'
  #DELETE 'sample/:id' => 'books#destroy'
  #PUT    'sample/:id' => 'books#update'
  
  # The priority is based upon order of creation:
  # first created -> highest priority.

  # Sample of regular route:
  #   match 'products/:id' => 'catalog#view'
  # Keep in mind you can assign values other than :controller and :action

  # Sample of named route:
  #   match 'products/:id/purchase' => 'catalog#purchase', :as => :purchase
  # This route can be invoked with purchase_url(:id => product.id)

  # Sample resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Sample resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Sample resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Sample resource route with more complex sub-resources
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', :on => :collection
  #     end
  #   end

  # Sample resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  # You can have the root of your site routed with "root"
  # just remember to delete public/index.html.
  # root :to => "welcome#index"

  # See how all your routes lay out with "rake routes"

  # This is a legacy wild controller route that's not recommended for RESTful applications.
  # Note: This route will make all actions in every controller accessible via GET requests.
  # match ':controller(/:action(/:id(.:format)))'
end
