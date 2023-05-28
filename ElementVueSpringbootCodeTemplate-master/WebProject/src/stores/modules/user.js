const user = {
    namespaced: true,
    state: {
        user:{ id: 0, 'name': '', value: 'hjxnmsl',Permissions:1,}
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