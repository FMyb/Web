<template>
  <div>
    <article v-for="post in viewPosts" :key="post.id">
      <div class="title">
        <a href="#" @click.prevent="changePageToPostId(post.id)">{{ post.title }}</a>
      </div>
      <div class="information">By {{ userById(post.userId).login }}</div>
      <div class="body">{{ post.text }}</div>
      <div class="footer">
        <div class="left">
          <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
          <span class="positive-score">+173</span>
          <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
        </div>
        <div class="right">
          <img src="../../assets/img/comments_16x16.png" title="Comments" alt="Comments"/>
          <a href="#" @click.prevent="changePageToPostId(post.id)">{{ commentsCountByPostId(post.id) }}</a>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
export default {
  name: "Index",
  props: ["posts", "users", "comments"],
  computed: {
    viewPosts: function () {
      return Object.values(this.posts).sort((a, b) => b.id - a.id);
    }
  },
  methods: {
    userById: function(id) {
      const users = Object.values(this.users).filter(u => u.id === id);
      return users[0];
    },
    commentsCountByPostId: function (id) {
      let comments = Object.values(this.comments).filter(c => c.postId === id);
      return Object.values(comments).length
    },
    changePageToPostId: function (id) {
      this.$root.$emit("onChangePageToPostId", id)
    }
  }
}
</script>

<style scoped>

</style>