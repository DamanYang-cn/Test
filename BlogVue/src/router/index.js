import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";
import ShowBlog from "../views/ShowBlog";
import Home from "../views/Home";
import Type from "../views/Type";
import DL from "../views/DL";
import About from "../views/About";
import Login from "../views/Login";
import Test from "../views/Test";

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'index',
    component: Index,
    redirect: '/home',
    show: true,
    children: [
      {
        path: '/home',
        name: '主页',
        show: true,
        component: Home
      },
      {
        path: '/type',
        name: '分类',
        show: true,
        component: Type
      },
      {
        path: '/dl',
        name: '下载',
        show: true,
        component: DL
      },
      {
        path: '/about',
        name: '关于',
        show: true,
        component: About
      },
      {
        path: '/showBlog',
        name: '博客详情',
        show: false,
        component: ShowBlog
      },
      {
        path: '/login',
        name: '登录',
        show: false,
        component: Login
      }
    ]
  },
  {
    path: '/test',
    name: '测试',
    component: Test
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
