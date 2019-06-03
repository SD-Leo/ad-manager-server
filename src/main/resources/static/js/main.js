var api = new Vue.resource('/api/organizations{/id}');
//import axios from 'axios';

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
  template:
    '<div>' +
      '<my-form :organizations="organizations"/>' +
      '<div v-for="org in organizations">{{ org.name }}</div>' +
      '<input type="file" id="file" ref="file" v-on:change="handleFileUpload()"/>' + // https://serversideup.net/uploading-files-vuejs-axios/
      '<div>' +
        '<button v-on:click="submitFile()">Upload file</button>' +
      '</div>' +
    '</div>'
  ,
  created: function () {
    api.get().then(result => result.json().then(data => data.forEach(org => this.organizations.push(org))));
  },
  methods: {
    handleFileUpload(){
      this.file = this.$refs.file.files[0];
    },
    submitFile(){
      /*
              Initialize the form data
          */
      let formData = new FormData();

      /*
          Add the form data we need to submit
      */
      formData.append('file', this.file);

      /*
        Make the request to the POST /single-file URL
      */
      axios.post( '/api/upload',
        formData,
        {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }
      ).then(function(){
        console.log('SUCCESS!!');
      })
        .catch(function(){
          console.log('FAILURE!!');
        });
    }
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
