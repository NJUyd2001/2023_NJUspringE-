<template>
    <el-form :inline="true" :model="form" class="demo-form-inline">
        <el-form-item label="名称">
            <el-input v-model="form.name" placeholder="名称在这里"></el-input>
        </el-form-item>
        <el-form-item label="学号">
            <el-input v-model="form.value" placeholder="学号在这里"></el-input>
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
                name: '你爹',
                value: '205220016',
                Permissions:0,
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
        }
    },
    created:{
        mounted(){
            this.name=this.$store.state.user.name;
            this.value=this.$store.state.user.value;
            //this.Permissions=this.$store.state.user.Permissions;
        }
    }
}
</script>