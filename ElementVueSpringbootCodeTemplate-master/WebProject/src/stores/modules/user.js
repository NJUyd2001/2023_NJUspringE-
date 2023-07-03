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
        }
    },
    actions: {
    }
}

export default user