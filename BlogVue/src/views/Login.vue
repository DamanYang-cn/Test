<template>
    <div>
        <h2>登录你的账号</h2>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

            <el-form-item label="用户名：" prop="name" style="width: 500px">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>

            <el-form-item label="密码：" prop="password" style="width: 500px">
                <el-input v-model="ruleForm.password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
            </el-form-item>

        </el-form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    name: '',
                    password: ''
                },
                rules: {
                    name: [
                        { required: true, message: '请输入用户名', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 6, message: '长度在6个字符以上个字符', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        console.log('submit successfully')
                        // const _this = this
                        axios.post('http://localhost:9091/user/login',this.ruleForm).then(function (resp) {
                            console.log(resp)
                            if(resp.data){
                                alert("true")
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            }
        }
    }
</script>