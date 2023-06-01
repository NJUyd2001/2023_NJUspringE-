const user = {
    namespaced: true,
    state: {
        id: 0,
        'name': '期末', 
        value: '吸氧',
        Permissions:1,
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