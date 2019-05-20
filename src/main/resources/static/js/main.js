
var api = new Vue.resource('/organizations{/id}');

Vue.component('my-form', {
    props: ['organizations'],
    data: function () {
        return {
            text: ''
        }
    },
    template: '<div>' +
        '<input type="text" v-model="text"/>' +
        '<input type="button" value="Save" @click="save"/>  ' +
        '</div>',
    methods: {
        save: function save() {
            console.log("Hello: " + this.text);
            var org = {name: this.text}
            api.save({}, org).then(result =>
                result.json().then(date => {
                this.organizations.push(date);
            }));
            this.text = '';
        }
    }
});

Vue.component('app-view', {
   props: ['organizations'],
   template: '<div>' +
       '<my-form :organizations="organizations"/>' +
       '<div v-for="org in organizations">{{ org.name }}</div>' +
       '</div>',
    created: function () {
        api.get().then(result => result.json().then(data => data.forEach(org => this.organizations.push(org))));
    }
});


var app = new Vue({
    el: '#app',
    template: '<app-view :organizations="orgs" />',
    data: {
        orgs: [
            // {'id': 1, 'name': "google"},
            // {'id': 2, 'name': "amazon"},
            // {'id': 3, 'name': "facebook"},
        ]
    }
});