<template>

    <v-data-table
        :headers="headers"
        :items="searchMenu"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SearchMenuView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            searchMenu : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/searchMenus'))

            temp.data._embedded.searchMenus.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.searchMenu = temp.data._embedded.searchMenus;
        },
        methods: {
        }
    }
</script>

