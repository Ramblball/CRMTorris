let form = new Vue({
    el: '#form',
    data: {
        name: '',
        password: ''
    },
    methods: {
        login: function() {
            if (this.name === '') {
                return;
            }
            if (this.password === '') {
                return;
            }
            axios({
                method: 'get',
                url: '/auth',
                data: {
                    name: this.name,
                    password: this.password
                },
                headers: {
                    "Content-type": "application/json"
                }
            })
            .catch(err => {
                console.log(err);
            });
        }
    }
})
