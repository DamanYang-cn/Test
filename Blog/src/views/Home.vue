<template>
    <div>
        <el-pagination
                background
                layout="prev, pager, next"
                :total="total"
                page-size="5"
                @current-change="page">
        </el-pagination>

        <div :data="tableData" v-for="item in tableData">
            <br/>
            <el-card class="box-card">
<!--                <el-image :src="{{item.pho}}"></el-image>-->
                <div slot="header" class="clearfix">
                    <el-button @click="showBlog(item.id)" type="text" size="small"><h2>{{item.title}}</h2></el-button>
                </div>
                <div class="text item">
                    分类：{{type[item.type-1].type}}
                    <br/>
                    描述：{{item.adj}}
                </div>
            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        methods: {
            page(currentPage){
                const _this = this
                axios.get('http://localhost:9091/test/findAll/'+currentPage).then(function (resp) {
                    console.log(resp)
                    _this.tableData = resp.data.content
                    _this.total = resp.data.totalElements
                })
            },
            showBlog(row) {
                this.$router.push({
                    path: '/showBlog',
                    query:{
                        id: row
                    }
                })
            },
        },
        created() {
            const _this = this
            axios.get('http://localhost:9091/test/findAll/1').then(function (resp) {
                console.log(resp)
                _this.tableData = resp.data.content
                _this.total = resp.data.totalElements
            })
            axios.get('http://localhost:9091/type/findAll').then(function (resp) {
                console.log(resp)
                _this.type = resp.data
            })
        },
        data(){
            return {
                total: null,
                tableData: null,
                type: null
            }
        }
    }
</script>

<style>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 680px;
    }
</style>