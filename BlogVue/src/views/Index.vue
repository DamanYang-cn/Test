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
                <el-button v-if="login" @click="onSubmit()">登录</el-button>
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
                login: null
            };
        },
        methods: {
            // handleSelect(key, keyPath) {
            //     console.log(key, keyPath);
            // },
            onSubmit(){
                this.$router.push({
                    path: '/login'
                })
            }
        },
        created() {
            const _this = this
            _this.login = true
            axios.get('http://localhost:9091/user/show').then(function (resp) {
                console.log(resp.data)
                // _this.login = resp.data
                // _this.login = true
            })
        }
    }
</script>


<style scoped>

</style>