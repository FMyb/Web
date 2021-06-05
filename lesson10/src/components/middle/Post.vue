<template>
  <div>
    <article v-if="post">
      <div class="title">
        <a href="#" @click.prevent="changePageToPostId(id)">{{ post.title }}</a>
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
          <a href="#" @click.prevent="changePageToPostId(id)">{{ commentsCountByPostId(post.id) }}</a>
        </div>
      </div>
      <div class="comment" v-for="comment in Object.values(comments).filter(c => c.postId === id).sort((a, b) => (b.id - a.id))" :key="comment.id">
        <span class="author">{{ userById(comment.userId).login }}: </span>
        <span class="text">{{ comment.text }}</span>
      </div>
    </article>
    <span v-if="!post">No such post</span>
  </div>
</template>

<script>
export default {
  name: "Post",
  data: function () {
    return {
      post: Object.values(this.posts).filter(p => p.id === this.id)[0]
    }
  },
  props: ["posts", "id", "users", "comments"],
  methods: {
    userById: function (id) {
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
.comment {
  margin-top: 0.5rem
}

.comment .author {
  color: darkgrey
}
</style>