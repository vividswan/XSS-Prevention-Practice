import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Main',
    component: () => import('../views/PostList')
  },
  {
    path: '/post/normal/:id',
    name: 'Post',
    component: () => import('../views/DetailPost2')
  },
  {
    path: '/post/add',
    name: 'AddPost',
    component: () => import('../views/AddPost')
  },
  {
    path: '/post/update/:id?',
    name: 'UpdatePost',
    component: () => import('../views/UpdatePost')
  },
  {
    path: '/post/detail/:id?',
    name: 'DetailPost',
    component: () => import('../views/DetailPost')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
