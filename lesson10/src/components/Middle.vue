<template>
  <div class="middle">
    <Sidebar :posts="viewPosts"/>
    <main>
      <Index v-if="page === 'Index'" :posts="posts" :users="users" :comments="comments"/>
      <Enter v-if="page === 'Enter'"/>
      <WritePost v-if="page === 'WritePost'"/>
      <EditPost v-if="page === 'EditPost'"/>
      <Register v-if="page === 'Register'"/>
      <Users v-if="page === 'Users'" :users="users"/>
      <Post v-if="page === 'Post'" :id="postId" :posts="posts" :users="users" :comments="comments"/>
    </main>
  </div>
</template>

<script>
import Sidebar from "@/components/sidebar/Sidebar";
import Index from "@/components/middle/Index";
import Enter from "@/components/middle/Enter";
import WritePost from "@/components/middle/WritePost";
import EditPost from "@/components/middle/EditPost";
import Register from "./middle/Register";
import Users from "./middle/Users";
import Post from "./middle/Post";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Index",
      postId: undefined
    }
  },
  components: {
    Post,
    Users,
    Register,
    WritePost,
    Enter,
    Index,
    Sidebar,
    EditPost
  },
  props: ["posts", "users", "comments"],
  computed: {
    viewPosts: function () {
      return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
    }
  }, beforeCreate() {
    this.$root.$on("onChangePage", (page) => this.page = page)
    this.$root.$on("onChangePageToPostId", (id) => {
          this.page = "Post";
          this.postId = id;
        }
    )
  }
}
</script>

<style scoped>

</style>