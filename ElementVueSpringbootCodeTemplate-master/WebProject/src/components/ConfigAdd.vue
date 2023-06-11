<template>
    <el-form :inline="true" :model="form" class="demo-form-inline">
        <el-form-item label="名称">
            <el-input v-model="form.name" placeholder="名称在这里"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="form.password" placeholder="密码在这里"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">添加</el-button>
        </el-form-item>
    </el-form>
</template>
<script>
export default {
    data() {
        return {
            form: {
                name: this.$store.state.user.name,
                password: this.$store.state.user.password,
                Permissions:this.$store.state.user.Permissions,
            }
        }
    },
    methods: {
        onSubmit() {
            let self = this;
            this.ajax.post('/config/add', this.form).then(result => {
                if (result.code == 0) {
                    self.info('add success, new id:' + result.data);

                    self.$store.dispatch('config/reload');
                }
                else {
                    self.error(result.msg);
                }
            })
        },
        // testVux(){
        //     alert(this.$store.state.user.name);
        //     this.name=this.$store.state.user.name;
        //     this.value=this.$store.state.user.value;
        //     this.Permissions=this.$store.state.user.Permissions;
        // }
    },
}
</script>