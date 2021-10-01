#!use_strict

let orderTable = new Vue({
    el: '#order_table',

    data() {
        return {
            page: 1,
            orders: null
        }
    },
    mounted() {
        // axios
        //     .get('http://localhost:8080/order/' + this.page + '/')
        //     .then(response => (this.orders = response))
        this.orders = [
            {
                time: '06.09.2021',
                id: 500,
                company: 'STL Expo',
                order: 'Dezarus',
                comment: 'Материал привезут позже',
                status: 'process'
            },
            {
                time: '06.09.2021',
                id: 501,
                company: 'STL Expo',
                order: 'Dezarus',
                comment: 'Материал привезут позже',
                status: 'complete'
            },
            {
                time: '06.09.2021',
                id: 502,
                company: 'STL Expo',
                order: 'Dezarus',
                comment: 'Материал привезут позже',
                status: 'freeze'
            },
            {
                time: '06.09.2021',
                id: 503,
                company: 'STL Expo',
                order: 'Dezarus',
                comment: 'Материал привезут позже',
                status: 'close'
            }
        ]
    }
})