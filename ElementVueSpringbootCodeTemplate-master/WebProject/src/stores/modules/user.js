const user = {
    namespaced: true,
    state: {
        id: "0",
        name: '期末', 
        password: '吸氧',
        Permissions:"t",
        process:{
            UID:"0",
            AID:"0",
        },
        
    },
    mutations: {
        changename (state,newname){
            state.user.name=newname
        },
        changeid (state,newid){
            state.user.id=newid
        },
        changepassword(state,newpassword){
            state.user.password=newpassword
        },
        changepermissions(state,newPermissions){
            state.user.Permissions=newPermissions
        },
        changeprocessuid(state,newprocessuid){
            state.user.process.UID=newprocessuid
        },
        changeprocessaid(state,newprocessaid){
            state.user.process.AID=newprocessaid
        },
    },
    actions: {
    }
}

export default user