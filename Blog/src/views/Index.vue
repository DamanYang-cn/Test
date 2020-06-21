<template>
    <div>
        <el-container>
<!--            <el-header>-->
<!--                <el-menu router :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">-->
<!--                    <h1>Welcome To Daman's Blog</h1>-->
<!--                    <el-menu-item-group v-for="(item,index) in $router.options.routes" :index="index+''">-->
<!--                        <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"-->
<!--                        :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>-->
<!--                    </el-menu-item-group>-->
<!--                </el-menu>-->
<!--            </el-header>-->

            <el-aside width="200px" style="background-color: rgb(255,255,255)">
                <h2>Daman's Blog</h2>
                <el-menu router>
                    <div v-for="(item,index) in $router.options.routes" :index="index+''">
<!--                        <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>-->
                        <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                                      :class="$route.path==item2.path?'is-active':''" v-if="item2.show">{{item2.name}}</el-menu-item>
                    </div>
                </el-menu>
                <el-button @click="onSubmit()">登录</el-button>
            </el-aside>

            <el-main>
                <router-view></router-view>
            </el-main>

        </el-container>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                activeIndex: '1',
                activeIndex2: '1',
                url: 'https://s1.ax1x.com/2020/06/20/N1AcPU.th.png'
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            onSubmit(){
                this.$router.push({
                    path: '/login'
                })
            }
        }
    }
</script>


<style scoped>

</style>