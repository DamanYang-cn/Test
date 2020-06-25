<template>
    <h1>Test</h1>
</template>

<script>
    export default {
        name: "Test",
        created() {
            const _this = this
            axios.get('http://localhost:9091/user/checkL')
                .then(function (resp) {
                    console.log(resp)
                })
                .catch(function (error) {
                    console.log(error)
                })
        }
    }
</script>

<style scoped>

</style>